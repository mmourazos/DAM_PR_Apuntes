using System;
using System.Collections.Generic;

namespace Cosas
{
    public class Persona
    {
        // Variable de clase.
        private static int num_personas = 0;

        // Variables de instancia.
        private string nombre;
        private string primerApellido;
        private string segundoApellido;
        private bool hombre;
        private bool mujer;
        private float sueldo;
        private string dni;
        private DateTime fecha_nacimiento;

        public string Nombre { get; set; }

        public string PrimeApellido { get; set; }

        public string SegundoApellido { get; set; }

        public string NombreCompleto
        {
            get
            {
                return $"{nombre} {primerApellido} {segundoApellido}";
            }
        }

        public string Sexo
        {
            set
            {
                if (value == "hombre")
                {
                    hombre = true;
                    mujer = false;
                }
                else if (value == "mujer")
                {
                    hombre = false;
                    mujer = true;
                } else
                {
                    throw new Exception("Sexo no válido.");
                }
            }

            get
            {
                if (hombre) { return "hombre"; }
                else { return "mujer"; }
            }
        }

        public string Dni { get; set; }

        public Persona(string nombre, string primerApellido, string segundoApellido, string fechaDeNacimiento, string sexo, float sueldo)
        {
            this.nombre = nombre;
            this.primerApellido = primerApellido;
            this.segundoApellido = segundoApellido;
            this.FechaNacimiento = fechaDeNacimiento;
            this.Sexo = sexo;
            this.Sueldo = sueldo;

            num_personas += 1;
        }

        public float Sueldo { get; set; }

        public string FechaNacimiento
        {
            get
            {
                return fecha_nacimiento.ToString();
            }

            set
            {
                this.fecha_nacimiento = DateTime.Parse(value);
            }
        }

        public int Edad
        {
            get
            {
                var now = DateTime.Now;
                var edad = now.Year - fecha_nacimiento.Year;

                if ((now.Month > fecha_nacimiento.Month) || (now.Month == fecha_nacimiento.Month && now.Day > fecha_nacimiento.Day))
                {
                    edad++;
                }

                return edad;
            }
        }

        public void Metodo()
        {
            // ...
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            List<Persona> personas = new List<Persona>(10);
            personas.Add(new Persona("Manuel", "Piñeiro", "Mourazos", "1977, 5, 15", "hombre", 1500));
            personas.Add(new Persona("Cristina", "Fernadez", "Garrido", "2001, 8, 25", "mujer", 2500));
            personas.Add(new Persona("Álvaro", "Pose", "Castro", "1997, 10, 7", "hombre", 1800.5f));
            personas.Add(new Persona("Tristan", "Gómez", "Pérez", "2010, 1, 30", "hombre", 300.9f));
            personas.Add(new Persona("Sara", "Salamanca", "Torres", "1999, 12, 31", "mujer", 3750.66f));
            personas.Add(new Persona("Fernando", "Fernandez", "Fernandez", "2000, 1, 11", "hombre", 2220.20f));
            personas.Add(new Persona("Cármen", "Abrente", "Montiel", "1992, 3, 17", "mujer", 1770.5f));
            personas.Add(new Persona("Cristiano Ronaldo", "dos Santos", "Aveiro", "1985, 2, 5", "hombre", 999999.999f));
            personas.Add(new Persona("Bat", "Man", "Wayne", "1915, 3, 7", "hombre", 000.0f));
        }

    }

}
