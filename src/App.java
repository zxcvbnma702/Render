public class App {
    public static void main(String[] args) throws Exception {

        Display window = new Display(800, 600, "Software Render");
        RenderContext target = window.GetFrameBuffer();
        Stars3D stars = new Stars3D(4096, 64.0f, 20.0f);

        Vertex minYVert = new Vertex(100, 100);
		Vertex midYVert = new Vertex(150, 200);
		Vertex maxYVert = new Vertex(80, 300);

        long previousTime = System.nanoTime();

        while(true)
        {
            long currentTime = System.nanoTime();
            float delta = (float)((currentTime - previousTime) / 1000000000.0);
            previousTime = currentTime;

            target.Clear((byte)0x00);
            // stars.UpdateAndRender(target, delta);

            target.ScanConvertTriangle(minYVert, midYVert, maxYVert, 0);
            target.FillShape(100, 300);

            window.SwapBuffers();
        }
    }
}
