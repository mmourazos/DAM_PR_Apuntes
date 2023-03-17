using WPFMVVMBasica.Model;

namespace WPFMVVMBasica.ViewModels
{
    internal class LibroViewModel : ViewModelBase
    {
        private readonly Libro _libro;

        private string _texto;

        public string Texto
        {
            get { return _texto; }

            set
            {
                _texto = value;
                OnPropertyChanged(nameof(Texto));
            }
        }

        public LibroViewModel(Libro libro)
        {
            _libro = libro;
        }
    }
}
