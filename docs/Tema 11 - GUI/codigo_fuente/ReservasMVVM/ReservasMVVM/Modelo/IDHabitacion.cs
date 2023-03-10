using System;

namespace ReservasMVVM.Modelo
{
    internal class IDHabitacion : IComparable<IDHabitacion>
    {
        public int NumeroPlanta { get; }

        public int NumeroHabitacion { get; }

        public override string ToString()
        {
            return $"{NumeroPlanta}{NumeroHabitacion}";
        }

        public int CompareTo(IDHabitacion other)
        {
            int valorEsta = 10 * NumeroPlanta + NumeroHabitacion;
            int valorOtra = 10 * other.NumeroPlanta + other.NumeroHabitacion;
            return (valorEsta - valorOtra);
        }

        public override bool Equals(object obj)
        {
            // El operador "is" cuando se escribe en la forma "XXX is Tipo variable":
            // 1.- La expresión retornará verdadero o falso dependiendo de si XXX es
            // del tipo Tipo.
            // 2.- Si la expresión devuelve verdadero además asignará XXX a variable
            // (siendo variable de tipo Tipo).
            return (obj is IDHabitacion idHabitacion && NumeroPlanta == idHabitacion.NumeroPlanta && NumeroHabitacion == idHabitacion.NumeroHabitacion);
        }
        public IDHabitacion(int numeroPlanta, int numeroHabitacion)
        {
            NumeroPlanta = numeroPlanta;
            NumeroHabitacion = numeroHabitacion;
        }
    }
}
