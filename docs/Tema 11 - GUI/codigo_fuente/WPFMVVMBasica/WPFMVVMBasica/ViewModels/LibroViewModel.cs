using System.ComponentModel;
using System.Windows.Input;
using WPFMVVMBasica.Commands;
using WPFMVVMBasica.Model;

namespace WPFMVVMBasica.ViewModels
{
    internal class LibroViewModel : ViewModelBase
    {
        private readonly Libro _libro;
        private int _pagina;

        public string Texto
        {
            get { return _libro.Texto; }

            set
            {
                _libro.Texto = value;
                OnPropertyChanged(nameof(Texto));
            }
        }

        public int NPagina
        {
            get { return _pagina; }

            set
            {
                _pagina = value;
                OnPropertyChanged(nameof(NPagina));
            }
        }

        private void ModelPropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            OnPropertyChanged(e.PropertyName);
        }

        public ICommand ComandoPasaAMayusculas { get; }
        
        public LibroViewModel(Libro libro)
        {
            _libro = libro;

            _libro.PropertyChanged += ModelPropertyChanged;

            ComandoPasaAMayusculas = new ComandoPasaAMayusculas(_libro);
        }
    }
}
