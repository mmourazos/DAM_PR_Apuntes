using ReservasMVVM.Modelo;
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
