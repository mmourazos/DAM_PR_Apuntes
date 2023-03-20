namespace ReservasMVVM.VistasModelos
{
    /// <summary>
    /// Este _View-Model_ establecerá cual es _View-Model_ que estará en uso en
    /// cada momento.
    /// </summary>
    internal class VistaModeloPrincipal : VistaModeloBase
    {
        public VistaModeloBase VistaModeloActual { get; }

        public VistaModeloPrincipal()
        {
            VistaModeloActual = new VistaModeloListarReservas();
        }
    }
}
