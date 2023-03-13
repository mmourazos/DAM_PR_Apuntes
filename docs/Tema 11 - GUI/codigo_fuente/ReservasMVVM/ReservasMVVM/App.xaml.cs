using ReservasMVVM.Modelo;
using System;
using System.Collections.Generic;
using System.Windows;

namespace ReservasMVVM
{
    /// <summary>
    /// Lógica de interacción para App.xaml
    /// </summary>
    public partial class App : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            Hotel hotel = new Hotel("Xanadú");

            hotel.HacerReserva(
                new Reserva(new IDHabitacion(3, 101), "Manuel Piñeiro",
                new DateTime(2023, 5, 7),
                new DateTime(2023, 5, 15)));
            hotel.HacerReserva(
                new Reserva(new IDHabitacion(3, 101), "Manuel Piñeiro",
                new DateTime(2023, 6, 7),
                new DateTime(2023, 6, 15)));
            hotel.HacerReserva(
                new Reserva(new IDHabitacion(3, 101), "Manuel Piñeiro",
                new DateTime(2023, 7, 7),
                new DateTime(2023, 7, 15)));

            IEnumerable<Reserva> reservas = hotel.ReservasCliente("Manuel Piñeiro");

            base.OnStartup(e);
        }
    }
}
