using Microsoft.EntityFrameworkCore.Diagnostics;
using System;

namespace Reservations.Modelo
{
    class IDHabitacion : IComparable<IDHabitacion>
    {

        public int NumPlanta { get; }

        public int NumHabitacion { get; }

        public IDHabitacion(int numPlanta, int numHabitacion)
        {
            NumPlanta = numPlanta;
            NumHabitacion = numHabitacion;
        }

        public int CompareTo(IDHabitacion? other)
        {
            if (other is null ) return 1;
            int valorEsta = 10 * NumPlanta + NumHabitacion;
            int valorOtra = 10 * other.NumPlanta + other.NumHabitacion;
            return (valorEsta - valorOtra);
        }

        public static bool operator ==(IDHabitacion id1, IDHabitacion id2)
        {
            if (id1 is null && id2 is null) { return true; }

            // El "null-coalescing operator" ?? son operators introducidos en C# 8.0 que "facilita" el trabajo con
            // valores nulos.
            // ?? devuelve el valor del operando a su izquierda si es distinto de null y el resultado de evaluar la
            // expresión a su derecha en caso contrario.

            return id1?.Equals(id2) ?? false;

            // Sería equivalente a: "return if id1 is not null && id1.Equals(id2);"
        }

        public static bool operator !=(IDHabitacion id1, IDHabitacion id2) { return !(id1 == id2); }
    }
}
