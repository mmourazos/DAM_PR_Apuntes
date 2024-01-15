using System.ComponentModel;

namespace WPFMVVMBasica.Model
{
    // Hacemos que implemente INotifyPropertyChanged porque queremos avisar al ViewModel
    // cuando cambie la propiedad Texto.
    // Al implementear INotifyPropertyChanged "aparecerá" el evento PropertyChanged al 
    // que han de subscribirse los objetos que quieran ser notificados de cambios en propiedades.
    internal class Libro : INotifyPropertyChanged
    {
        private string _texto;

        public event PropertyChangedEventHandler PropertyChanged;

        // Cuando la propiedad cambie invocaremos este método para avisar a los 
        // subscriptores
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
                // Cuando cambia avisamos a los subscriptores indicando el nombre
                // de la porpiedad que ha cambiado.
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
