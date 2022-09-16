public class Vertex{
    private float m_x;
    private float m_y;

    public float GetX(){return m_x;}
    public float GetY(){return m_y;}

    public void SetX(float x) {
        this.m_x = x;
    }

    public void SetY(float y) {
        this.m_y = y;
    }

    public Vertex(float x, float y){
        this.m_x = x;
        this.m_y = y;
    }

}