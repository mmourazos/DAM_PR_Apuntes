public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Juan", 20, Persona.HOMBRE);
        Persona p3 = new Persona("Ana", 30, "32781464R", Persona.MUJER, 60, 170);
        System.out.println(p1);
        System.out.println();
        System.out.println(p2);
        System.out.println();
        System.out.println(p3);

        if (p3.calcularIMC() == Persona.BAJO_PESO) {
            System.out.println("con bajo peso.");
        } else if (p3.calcularIMC() == Persona.PESO_IDEAL) {
            System.out.println("en su peso ideal.");
        } else {
            System.out.println("con sobrepeso.");
        }
    }
}
