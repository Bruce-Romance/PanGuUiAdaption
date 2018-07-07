package dimens.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import dimens.constants.DimenHeight;
import dimens.constants.DimenWidths;


public class MakeUtils {

    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n";
    private static final String XML_RESOURCE_START = "<resources>\r\n";
    private static final String XML_RESOURCE_END = "</resources>\r\n";
    private static final String XML_DIMEN_Y_LINE = "<dimen name=\"y_%1$spx_%2$d\">%3$.2fdp</dimen>\r\n";
    private static final String XML_DIMEN_X_LINE = "<dimen name=\"x_%1$spx_%2$d\">%3$.2fdp</dimen>\r\n";
    private static final String XML_BASE_DPI = "<dimen name=\"base_dpi\">%ddp</dimen>\r\n";


    /**
     * 生成的文件名
     */
    private static final String XML_NAME = "dimens.xml";


    public static float px2dip(float pxValue, int sw, int designWidth) {
        float dpValue = (pxValue / (float) designWidth) * sw;
        BigDecimal bigDecimal = new BigDecimal(dpValue);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }


    /**
     * 生成所有的尺寸数据
     *
     * @return
     */
    private static String makeAllDimens(DimenWidths dimenWidths, DimenHeight dimenHeight, int designWidth, int designHeight) {
        float dpValue;
        String temp;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(XML_HEADER);
            sb.append(XML_RESOURCE_START);
            //备份生成的相关信息
            temp = String.format(XML_BASE_DPI, dimenWidths.getSwWidthDp());
            sb.append(temp);
            //生成宽度DP
            for (int i = 0; i <= designWidth; i++) {
                dpValue = px2dip((float) i, dimenWidths.getSwWidthDp(), designWidth);
                temp = String.format(XML_DIMEN_X_LINE, "", i, dpValue);
                sb.append(temp);
            }
            //生成高度DP
            for (int j = 0; j <= designHeight; j++) {
                dpValue = px2dip((float) j, dimenHeight.getShHeightDp(),designHeight);
                temp = String.format(XML_DIMEN_Y_LINE, "", j, dpValue);
                sb.append(temp);
            }


            sb.append(XML_RESOURCE_END);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    /**
     * 生成的目标文件夹
     * 只需传宽进来就行
     *
     * @param buildDir 生成的目标文件夹
     */
    public static void makeAll(int designWidth, int designHeight, DimenWidths dimenWidths,DimenHeight dimenHeight, String buildDir) {
        try {
            //生成规则
            final String folderName;
            if (dimenWidths.getSwWidthDp() > 0) {
                //适配Android 3.2+
                folderName = "values-sw" + dimenWidths.getSwWidthDp() + "dp";
            } else {
                return;
            }

            //生成目标目录
            File file = new File(buildDir + File.separator + folderName);
            if (!file.exists()) {
                file.mkdirs();
            }

            //生成values文件
            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + File.separator + XML_NAME);
            fos.write(makeAllDimens(dimenWidths,dimenHeight, designWidth, designHeight).getBytes());
            fos.flush();
            fos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
