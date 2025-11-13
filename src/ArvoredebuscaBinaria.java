public class ArvoredebuscaBinaria {
    private No raiz;

    public ArvoredebuscaBinaria() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null)
            return new No(valor);
        if (valor < atual.valor)
            atual.esquerda = inserirRec(atual.esquerda, valor);
        else if (valor > atual.valor)
            atual.direita = inserirRec(atual.direita, valor);
        return atual;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == null)
            return false;
        if (valor == no.valor)
            return true;
        return valor < no.valor
                ? buscarRecursivo(no.esquerda, valor)
                : buscarRecursivo(no.direita, valor);
    }

    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private No removerRec(No atual, int valor) {
        if (atual == null)
            return null;
        if (valor < atual.valor)
            atual.esquerda = removerRec(atual.esquerda, valor);
        else if (valor > atual.valor)
            atual.direita = removerRec(atual.direita, valor);
        else {
            if (atual.esquerda == null)
                return atual.direita;
            else if (atual.direita == null)
                return atual.esquerda;
            atual.valor = buscarMenor(atual.direita).valor;
            atual.direita = removerRec(atual.direita, atual.valor);
        }
        return atual;
    }

    private No buscarMenor(No atual) {
        while (atual.esquerda != null)
            atual = atual.esquerda;
        return atual;
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdemRec(raiz);
        System.out.println();
    }

    private void imprimirEmOrdemRec(No no) {
        if (no != null) {
            imprimirEmOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdemRec(no.direita);
        }
    }

    public void imprimirPreOrdem() {
        imprimirPreOrdemRec(raiz);
        System.out.println();
    }

    private void imprimirPreOrdemRec(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            imprimirPreOrdemRec(no.esquerda);
            imprimirPreOrdemRec(no.direita);
        }
    }

    public void imprimirPosOrdem() {
        imprimirPosOrdemRec(raiz);
        System.out.println();
    }

    private void imprimirPosOrdemRec(No no) {
        if (no != null) {
            imprimirPosOrdemRec(no.esquerda);
            imprimirPosOrdemRec(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(No no) {
        if (no == null)
            return -1;
        int altEsq = alturaRec(no.esquerda);
        int altDir = alturaRec(no.direita);
        return Math.max(altEsq, altDir) + 1;
    }

    public int contarNos() {
        return contarNosRec(raiz);
    }

    private int contarNosRec(No no) {
        if (no == null)
            return 0;
        return 1 + contarNosRec(no.esquerda) + contarNosRec(no.direita);
    }

    public int contarFolhas() {
        return contarFolhasRec(raiz);
    }

    private int contarFolhasRec(No no) {
        if (no == null)
            return 0;
        if (no.esquerda == null && no.direita == null)
            return 1;
        return contarFolhasRec(no.esquerda) + contarFolhasRec(no.direita);
    }

    public int profundidadeNo(int valor) {
        return profundidadeNoRec(raiz, valor, 0);
    }

    private int profundidadeNoRec(No no, int valor, int profundidade) {
        if (no == null)
            return -1;
        if (valor == no.valor)
            return profundidade;
        if (valor < no.valor)
            return profundidadeNoRec(no.esquerda, valor, profundidade + 1);
        else
            return profundidadeNoRec(no.direita, valor, profundidade + 1);
    }
}