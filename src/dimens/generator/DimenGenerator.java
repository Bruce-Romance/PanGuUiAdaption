package dimens.generator;

import dimens.constants.DimenHeight;
import dimens.constants.DimenWidths;
import dimens.utils.MakeUtils;

public class DimenGenerator {

    /**
     * 设计稿尺寸(根据自己设计师的设计稿的宽度填入)
     */
    private static final int DESIGN_WIDTH = 720;

    /**
     * 设计稿高度
     */
    private static final int DESIGN_HEIGHT = 1280;

    public static void main(String[] args) {

        DimenWidths[] widths = DimenWidths.values();
        DimenHeight[] heights = DimenHeight.values();
        for (int i= 0;i<widths.length;i++){
            MakeUtils.makeAll(DESIGN_WIDTH, DESIGN_HEIGHT, widths[i], heights[i], "/androidui/adapter");
        }
    }

}
