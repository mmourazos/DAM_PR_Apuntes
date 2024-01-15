using AdivinaElNumero.Model;
using AdivinaElNumero.ViewModels;
using System;
using System.Windows;

namespace AdivinaElNumero
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
                DataContext = new PartidaViewModel(new Partida())
            };

            MainWindow.Show();

            base.OnStartup(e);
        }
    }
}
