package iticbcn.cat;

public class Motor {
    private int potencia_objectiu;
    private int potencia_actual;

    public Motor() {
        this.potencia_objectiu = 0;
        this.potencia_actual = 0;
    }
    public void setPotenciaObjectiu(int potencia_objectiu) {
        this.potencia_objectiu = potencia_objectiu;
    }

    public void setPotenciaActual(int potencia_actual) {
        this.potencia_actual = potencia_actual;
    }
}
