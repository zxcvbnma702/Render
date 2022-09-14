import java.awt.*;
import java.awt.image.*;

import javax.swing.JFrame;

public class Display extends Canvas{

    private final JFrame         m_frame;
    private final RenderContext        m_frameBuffer;
    private final BufferedImage  m_displayImage;
    private final byte[]         m_displayComponents;
    private final BufferStrategy m_bufferStrategy;
    private final Graphics       m_graphics;

    
    public Display(int width, int height, String title) {
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setMinimumSize(size);
        setMaximumSize(size);

        //创建展示用的位图
        m_frameBuffer = new RenderContext(width, height);
        m_displayImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        m_displayComponents = ((DataBufferByte)m_displayImage.getRaster().getDataBuffer()).getData();

        m_frameBuffer.Clear((byte)0x80);
		m_frameBuffer.DrawPixel(100, 100, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0xFF);

        m_frame = new JFrame();
        m_frame.add(this);
        m_frame.pack();
        m_frame.setResizable(false);
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setLocationRelativeTo(null);
        m_frame.setVisible(true);
        m_frame.setTitle(title);

        createBufferStrategy(1);
        m_bufferStrategy = getBufferStrategy();
        m_graphics = m_bufferStrategy.getDrawGraphics();
	}

    public void SwapBuffers()
    {
        m_frameBuffer.CopyToByteArray(m_displayComponents);
        m_graphics.drawImage(m_displayImage, 0, 0, m_frameBuffer.getWidth(), m_frameBuffer.getHeight(), null);
        m_bufferStrategy.show();
    }

    public RenderContext GetFrameBuffer(){
        return m_frameBuffer;
    }
}
