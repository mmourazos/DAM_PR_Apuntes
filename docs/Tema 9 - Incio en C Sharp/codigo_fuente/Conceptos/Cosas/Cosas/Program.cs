using System;
using System.Collections;
using System.Collections.Generic;

namespace Cosas
{
    public class Persona
    {
        // Variable de clase.
        private static int num_personas = 0;
        private static readonly char[] LETRAS_DNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

        // Métodos de clase.
        public static bool EsDniValido(string dni)
        {
            int numero = int.Parse(dni.Substring(0, dni.Length - 1));

            char letra = char.Parse(dni.Substring(dni.Length - 1));
            int pos_letra = numero % LETRAS_DNI.Length;

            return letra == LETRAS_DNI[pos_letra];
        }

        private static int Cifras(int num_cifras)
        {
            Random r = new Random();

            int valor = 0;
            for (int i = 0; i < num_cifras; ++i)
            {
                valor += (int)Math.Pow(10, i) * r.Next(10);
            }

            return valor;
        }
        public static string GeneraDniValido()
        {
            int numero = Cifras(7);
            char letra = LETRAS_DNI[numero % LETRAS_DNI.Length];

            return $"{numero}{letra}";
        }
        // Variables de instancia.

        private bool _hombre;
        private bool _mujer;
        private float _sueldo;
        private string _dni;
        private DateTime _fecha_nacimiento;

        public string Nombre { get; set; }

        public string PrimerApellido { get; set; }

        public string SegundoApellido { get; set; }

        public string NombreCompleto
        {
            get
            {
                return $"{Nombre} {PrimerApellido} {SegundoApellido}";
            }
        }

        public string Sexo
        {
            set
            {
                if (value == "hombre")
                {
                    _hombre = true;
                    _mujer = false;
                }
                else if (value == "mujer")
                {
                    _hombre = false;
                    _mujer = true;
                }
                else
                {
                    throw new Exception("Sexo no válido.");
                }
            }

            get
            {
                if (_hombre) { return "hombre"; }
                else { return "mujer"; }
            }
        }

        public string Dni
        {
            get
            {
                return _dni;
            }

            set
            {
                if (EsDniValido(value))
                {
                    this._dni = value;
                }
                else
                {
                    throw new ArgumentException($"El DNI \"{value}\" no es válido.");
                }
            }
        }

        public Persona(string nombre, string primerApellido, string segundoApellido, string dni, string fechaDeNacimiento, string sexo, float sueldo)
        {
            ++num_personas;
            Nombre = nombre;
            PrimerApellido = primerApellido;
            SegundoApellido = segundoApellido;
            Dni = dni;
            FechaNacimiento = fechaDeNacimiento;
            Sexo = sexo;
            Sueldo = sueldo;
        }

        public float Sueldo { get; set; }

        public string FechaNacimiento
        {
            get
            {
                return _fecha_nacimiento.ToString();
            }

            set
            {
                _fecha_nacimiento = DateTime.Parse(value);
            }
        }

        public int Edad
        {
            get
            {
                var now = DateTime.Now;
                var edad = now.Year - _fecha_nacimiento.Year;

                if ((now.Month > _fecha_nacimiento.Month) || (now.Month == _fecha_nacimiento.Month && now.Day > _fecha_nacimiento.Day))
                {
                    edad++;
                }

                return edad;
            }
        }

        public void Metodo()
        {
            LETRAS_DNI[0] = 'a';
            Console.Write(LETRAS_DNI);
        }

        public override string ToString()
        {
            return $"{Nombre} {PrimerApellido}";
        }

    }

    class Program
    {
        public static void SumaRef(int x, ref int y)
        {
            y += x;
        }

        public static void SumaOut(int x, int y, out int z)
        {
            z = x + y;
        }

        public static int Total(int x, params int[] valores)
        {
            int total = 0;

            foreach (int v in valores)
            {
                total += v;
            }

            return total;
        }

        public static void PruebaHashtable()
        {
            Hashtable ht = new Hashtable();

            ht.Add(1, "uno");
            ht.Add(2, "dos");
            ht.Add(3, "tres");
            ht.Add(4, "cuatro");
            ht.Add(5, "cinco");
            ht.Add(6, "seis");
            ht.Add(7, "siete");
            ht.Add(8, "ocho");
            ht.Add(9, "nueve");
            ht.Add(10, "diez");

            foreach (DictionaryEntry entry in ht)
            {
                Console.WriteLine($"clave: {entry.Key} -> value: {entry.Value}.");
            }


        }

        static void Main(string[] args)
        {
            ArrayList personas = new ArrayList(10);

            personas.Add(new Persona("Manuel", "Piñeiro", "Mourazos", Persona.GeneraDniValido(), "1977, 5, 15", "hombre", 1500));
            personas.Add(new Persona("Cristina", "Fernadez", "Garrido", Persona.GeneraDniValido(), "2001, 8, 25", "mujer", 2500));
            personas.Add(new Persona("Álvaro", "Pose", "Castro", Persona.GeneraDniValido(), "1997, 10, 7", "hombre", 1800.5f));
            personas.Add(new Persona("Tristan", "Gómez", "Pérez", Persona.GeneraDniValido(), "2010, 1, 30", "hombre", 300.9f));
            personas.Add(new Persona("Sara", "Salamanca", "Torres", Persona.GeneraDniValido(), "1999, 12, 31", "mujer", 3750.66f));
            personas.Add(new Persona("Fernando", "Fernandez", "Fernandez", Persona.GeneraDniValido(), "2000, 1, 11", "hombre", 2220.20f));
            personas.Add(new Persona("Cármen", "Abrente", "Montiel", Persona.GeneraDniValido(), "1992, 3, 17", "mujer", 1770.5f));
            personas.Add(new Persona("Cristiano Ronaldo", "dos Santos", "Aveiro", Persona.GeneraDniValido(), "1985, 2, 5", "hombre", 999999.999f));
            personas.Add(new Persona("Bat", "Man", "Wayne", Persona.GeneraDniValido(), "1915, 3, 7", "hombre", 000.0f));

            PruebaHashtable();
        }

    }
}
