using System.ComponentModel;

namespace WPFMVVMBasica.ViewModels
{
    // Todos los "ViewModels" heredarán de "ViewModelBase", por lo que todos 
    // heredarán este código y expondrán el evento "PropertyChanged".
    internal class ViewModelBase : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        public void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
