namespace Tarea3
{
    public class Abecedario : IENumerable<char>
    {
        private char[] abecedario = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        public IEnumerator<char> GetEnumerator()
        {
            for (int i = 0; i < abecedario.Length; ++i)
            {
                yield return abecedario[i];
            }
        }
    }

    class AbecedarioB : IENumerable<char>
    {
        private char[] abecedario = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        private int[] vocalPos = { 0, 4, 8, 14, 20 };

        public IEnumerator<char> GetEnumerator()
        {
            for (int i = 0; i < abecedario.Length; ++i)
            {
                yield return abecedario[i];
            }
        }

        public IEnumerator<char> GetVocals()
        {
            for (int i = 0; i < vocalPos.Length; ++i)
            {
                yield return abecedario[vocalPos[i]];
            }

        }
    }

    class Vocals : AbecedarioB
    {
        public override IENumerator<char> GetENumerator()
        {
            return GetVocals;
        }
    }
}


