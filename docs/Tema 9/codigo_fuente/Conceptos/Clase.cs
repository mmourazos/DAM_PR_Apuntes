namespace Cosas
{
    public class Persona
    {
        private static int num_personas = 0;
        private DateTime fecha_nacimiento;

        public Persona(DateTime fecha_nacimiento)
        {
            this.fecha_nacimiento = fecha_nacimiento;
        }

        public DateTime FechaNacimiento
        {
            get
            {
                return fecha_nacimiento;
            }

            set;
        }

        public int Edad
        {
            get
            {
                var now = DateTime.Now;
                var edad = now.Year - fecha_nacimiento.Year;

                if ((now.Month > fecha_nacimiento.Month) || (now.Month == fecha_nacimiento.Month && now.DayOfMonth > fecha_nacimiento.DayOfMonth)) {
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

    static void Main(string[] args)
    {
        var p = new Persona(new DateTime(1990, 1, 1));
        Console.WriteLine(p.Edad);
    }

}