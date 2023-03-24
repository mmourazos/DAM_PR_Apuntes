namespace Reservations.ViewModels
{
    class MainViewModel : ViewModelBase
    {
        public ViewModelBase CurrentViewModel { get; set; }

        public MainViewModel()
        {
            // Código temporal:
            CurrentViewModel = new HacerReservaViewModel();
        }
    }
}
