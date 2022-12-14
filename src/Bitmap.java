import java.util.Arrays;

public class Bitmap{
    /** The width and height, in pixels, of the image */
    private final int m_width;
    private final int m_height;
    /** Every pixel component in the image */
    private final byte m_components[];

    public Bitmap(int width, int height){
        m_width      = width;
        m_height     = height;
        m_components = new byte[width * height * 4];
    }

    public void Clear(byte shade)
    {
        Arrays.fill(m_components, shade);
    }


    public void DrawPixel(int x, int y, byte a, byte b, byte g, byte r)
    {
        int index = (y * m_width + x) * 4;
        m_components[index] = a;
        m_components[index + 1] = b;
        m_components[index + 2] = g;
        m_components[index + 3] = r;
    }

    public void CopyToByteArray(byte[] dest)
    {
        for(int i = 0; i < m_width * m_height; i++)
        {
            dest[i * 3] = m_components[i * 4 + 1];
            dest[i * 3 + 1] = m_components[i * 4 + 2];
            dest[i * 3 + 2] = m_components[i * 4 + 3];
        }
    }

    public int getWidth(){
        return m_width;
    }

    public int getHeight(){
        return m_height;
    }
} 