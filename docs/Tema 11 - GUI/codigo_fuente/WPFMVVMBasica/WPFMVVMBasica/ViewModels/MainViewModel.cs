using WPFMVVMBasica.Model;

namespace WPFMVVMBasica.ViewModels
{
    internal class MainViewModel : ViewModelBase
    {
        public ViewModelBase CurrentViewModel { get; }

        public MainViewModel()
        {
            CurrentViewModel = new LibroViewModel(new Libro("La razón de la sinrazón."));
        }
    }
}
