
class Main {
    public static void main(String[] args) {
        ArvoredebuscaBinaria arvore = new ArvoredebuscaBinaria();
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(60);
        arvore.inserir(40);

        arvore.imprimirEmOrdem();
        arvore.imprimirPreOrdem();
        arvore.imprimirPosOrdem();

        System.out.println(arvore.altura());
        System.out.println(arvore.contarNos());
        System.out.println(arvore.contarFolhas());
        System.out.println(arvore.profundidadeNo(40));
        System.out.println(arvore.buscar(60));
        System.out.println(arvore.buscar(100));

        arvore.remover(70);
        arvore.imprimirEmOrdem();
    }
}