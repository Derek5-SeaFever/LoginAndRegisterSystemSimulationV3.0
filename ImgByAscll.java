import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图片生成ASCII码
 * */
public class ImgByAscII {
    /**
     * 根据图片生成ASCII码
     * @param path 图片路径
     */
    public static void createAsciiPic(final String path) {
        // 字符串，由复杂到简单
        final String base = "@#&$%*o!;.";
        try {
            // 将图片分解为像素点
            final BufferedImage image = ImageIO.read(new File(path));
            // 计算出每个点的灰度值,根据不同的灰度用不同的字符填充.
            for (int y = 0; y < image.getHeight(); y += 2) {
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                System.out.println();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
