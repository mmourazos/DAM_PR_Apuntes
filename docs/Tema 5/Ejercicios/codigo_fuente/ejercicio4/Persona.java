package ejercicio4;

import java.sql.Date;

public class Persona {
    public static final int HOMBRE = 1;
    public static final int MUJER = 2;

    public static final int BAJO_PESO = -1;
    public static final int PESO_IDEAL = 0;
    public static final int SOBREPESO = 1;

    private String nombre;
    private Date fechaNacimiento;
    private String dni;
    private int sexo;
    private double peso;
    private double altura;

    public Persona(String nombre, Date fecha, String dni, int sexo, double altura,
            double peso) {
        this.nombre = nombre;
        this.fechaNacimiento = fecha;

        this.dni = dni;
        if (sexo != HOMBRE && sexo != MUJER)
            this.sexo = sexo;
        else
            sexo = HOMBRE;
        this.altura = altura;
        this.peso = peso;
    }

    public double calcularIMC() {
        double imc = peso / Math.pow(altura, 2);
        if (imc < 20) {
            return BAJO_PESO;
        } else if (20 >= imc && imc <= 25) {
            return PESO_IDEAL;
        }
        return SOBREPESO;
    }
}
