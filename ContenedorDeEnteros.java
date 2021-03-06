public class ContenedorDeEnteros {
    class NodoBinario {
        Comparable clave;
        NodoBinario[] enlaces;

        public NodoBinario(Comparable info){
            clave = info;
            enlaces = new NodoBinario[2];
            enlaces[0] = null;
            enlaces[1] = null;
        }
    }

    protected int numElem;
    private NodoBinario raiz;
    private boolean resultado;

    public ContenedorDeEnteros(){
        raiz = null;
        numElem = 0;
    }

    public int cardinal(){
        return numElem;
    }

    public boolean buscar(int n) {
        return buscar(raiz, n);
    }

    protected boolean buscar(NodoBinario nodo, int n){
        while (nodo != null) {
            if (n == (Integer) nodo.clave) {
                return true;
            } else if (n < (Integer) nodo.clave) {
                nodo = nodo.enlaces[0];
            } else {
                nodo = nodo.enlaces[1];
            }
        }
        return false;
    }


    public boolean insertar(int n){
        if (!buscar(n)) {
            raiz = insertar(raiz, n);
        } else {
            return false;
        }
        return resultado;
    }

    private NodoBinario insertar(NodoBinario nodo, int n){
        if (nodo == null) {
            numElem++;
            resultado = true;
            nodo = new NodoBinario(n);
        } else {
            if (n != (Integer)nodo.clave) {
                if (n <(Integer)nodo.clave) {
                    nodo.enlaces[0] = insertar(nodo.enlaces[0],n);
                } else {
                    nodo.enlaces[1] = insertar(nodo.enlaces[1],n);
                }
            }
        }
        return nodo;
    }

    public boolean extraer(int n){
        if (!buscar(n)) return false;
            raiz = extraer(raiz, n);
        return true;
    }

    private NodoBinario extraer(NodoBinario nodo, int n) {
        if (nodo!=null) {
            if (n == (Integer)nodo.clave) {
                if ((nodo.enlaces[0] == null) || (nodo.enlaces[1] == null)) {
                    numElem--;
                    if (nodo.enlaces[0] == null) {
                        return nodo.enlaces[1];
                    } else {
                        return nodo.enlaces[0];
                    }
                } else {
                    nodo.enlaces[1] = extraerSucesor(nodo, nodo.enlaces[1]);
                }
            } else {
                if (n < (Integer)nodo.clave) {
                    nodo.enlaces[0] = extraer(nodo.enlaces[0],n);
                } else {
                    nodo.enlaces[1] = extraer(nodo.enlaces[1],n);
                }
            }
        }
        return nodo;
    }

    private NodoBinario extraerSucesor(NodoBinario nodoExtraer, NodoBinario nodo){
        if (nodo.enlaces[0]==null) {
            nodoExtraer.clave = nodo.clave;
            numElem--;
            nodo = nodo.enlaces[1];
        } else {
            nodo.enlaces[0] = extraerSucesor(nodoExtraer, nodo.enlaces[0]);
        }
        return nodo;
    }


    public void vaciar(){
        raiz = null;
        numElem = 0;
    }

    public int[] elementos(){
        int[] res = new int[numElem];
        return res;
    }
}
