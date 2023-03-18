using AdivinaElNumero.Modelo;
using AdivinaElNumero.VistasModelo;
using System.Windows;

namespace AdivinaElNumero
{
    /// <summary>
    /// Lógica de interacción para App.xaml
    /// </summary>
    public partial class App : Application
    {
        private Partida _partida;

        public App()
        {
            _partida = new Partida();
        }

        protected override void OnStartup(StartupEventArgs e)
        {
            MainWindow = new MainWindow()
            {
                DataContext = new VistaModeloPartida(_partida)
            };

            MainWindow.Show();

            base.OnStartup(e);
        }
    }
}
