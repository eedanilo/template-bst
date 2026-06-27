import java.util.ArrayList;

public class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */

    public Node iterativeSearch(int element) {
        if(this.isEmpty()) {
            throw new RuntimeException("Árvore vazia");
        }
        Node aux = this.root;
        while (aux != null) {
            if (aux.value == element) {
                return aux;
            }
            else if (element < aux.value) {
                aux = aux.left;
            }
            else {
                aux = aux.right;
            }
        }
        return null;
    }


    public Node search(int element) {
        if(this.isEmpty()) {
            throw new RuntimeException("Árvore vazia");
        }
        return search(this.root, element);
    }

    private Node search(Node root, int element) {
        if (root == null) {
            return null;
        }
        if (root.value == element) {
            return root;
        }
        if (element > root.value) {
            return search(root.right, element);
        }
        else {
            return search(root.left, element);
        }
    }
    
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        if(isEmpty()) {
            return -1;
        }
        return height(this.root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }


    public boolean equals(BST outra) {
        if (outra == null) {
            return false;
        }
        if (this.size != outra.size) {
            return false;
        }
        return equals(this.root, outra.root);
    }

    private boolean equals(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.value != n2.value) {
            return false;
        }
        return equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        if (this.isEmpty()) {
            return 0;
        }
        return contaFolhas(this.root);
    }

    private int contaFolhas(Node no) {
        if (no.left == null && no.right == null) {
            return 1;
        }
        if (no.left == null) {
            return contaFolhas(no.right);
        }
        if (no.right == null) {
            return contaFolhas(no.left);
        }
        return contaFolhas(no.left) + contaFolhas(no.right);
    }

    public Node sucessor(int v) {
        if (this.contains(v)){
            return sucessor(search(v));
        }
        return sucessorNC(this.root, v);
    }

    private Node sucessorNC(Node no, int v) {
        Node candidato = null;
        Node atual = no;
        while (atual != null) {
            if (atual.value == v) {
                return sucessor(atual);
            }
            else if (atual.value < v) {
                atual = atual.right;
            }
            else {
                candidato = atual;
                atual = atual.left;
            }
        }
        return candidato;
    }

    private Node sucessor(Node no) {
        if (no.right == null && no.parent == null) {
            return null;
        }
        else if (no.right == null) {
            Node atual = no;
            while (atual.parent != null && atual.parent.right == atual) {
                atual = atual.parent;
            }
            return atual.parent;
        }
        Node atual = no.right;
        while (atual.left != null) {
            atual = atual.left;
        }
        return  atual;
    }

    public boolean contains(int v) {
        return search(v) != null;
    }

    

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    
}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }
    
}
