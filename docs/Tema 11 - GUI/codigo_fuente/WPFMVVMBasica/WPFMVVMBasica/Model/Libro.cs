using System.ComponentModel;

namespace WPFMVVMBasica.Model
{
    internal class Libro : INotifyPropertyChanged
    {
        private string _texto;

        public event PropertyChangedEventHandler PropertyChanged;

        private void OnPropertyChanged(string propertyName)
         {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public string Texto
        {
            get
            {
                return _texto;
            }
            set
            {
                _texto = value;
                OnPropertyChanged(nameof(Texto));
            }
        }

        public void PasaAMayusculas()
        {
            Texto = Texto.ToUpper();
        }

        public Libro(string texto)
        {
            Texto = texto;
        }
    }
}
