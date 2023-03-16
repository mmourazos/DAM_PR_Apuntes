namespace ReservasMVVM.VistasModelos
{
    internal class MainViewModel : VistaModeloBase
    {
        private int _intentos;

        public int Intentos
        {
            get { return _intentos; }
            set
            {
                _intentos = value;
                OnPropertyChanged(nameof(Intentos));
            }
        }


    }
}
