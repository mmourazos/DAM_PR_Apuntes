using Reservations.Modelo;
using Reservations.Stores;
using Reservations.ViewModels;
using System.Windows;

namespace Reservations
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        private readonly Hotel _hotel;

        private readonly NavigationStore _navigationStore;

        public App()
        {
            _hotel = new Hotel("Vilagarcía continental");

            _navigationStore = new NavigationStore();
        }

        protected override void OnStartup(StartupEventArgs e)
        {
            _navigationStore.CurrentViewModel = new ListarReservasViewModel();

            MainWindow = new MainWindow()
            {
                DataContext = new MainViewModel(_navigationStore)
            }

            MainWindow.Show();

            base.OnStartup(e);
        }
    }
}
