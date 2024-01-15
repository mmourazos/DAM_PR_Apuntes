using ReservasMVVM.Modelo;
using ReservasMVVM.Stores;
using ReservasMVVM.VistasModelos;
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
        private readonly Hotel _hotel;
        private readonly NavigationStore _navigationStore;

        public App()
        {
            _hotel = new Hotel("Nuestro hotel");
            _navigationStore = new NavigationStore();
        }
        protected override void OnStartup(StartupEventArgs e)
        {


            MainWindow = new MainWindow()
            {
                DataContext = new VistaModeloPrincipal()
            };

            MainWindow.Show();

            base.OnStartup(e);
        }
    }
}
