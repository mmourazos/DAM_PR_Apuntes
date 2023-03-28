using Reservations.ViewModels;

namespace Reservations.Stores
{
    class NavigationStore
    {
        private ViewModelBase _currentViewModel;

        public ViewModelBase CurrentViewModel
        {
            get { return _currentViewModel; }

            set { _currentViewModel = value; }
        }
    }
}
