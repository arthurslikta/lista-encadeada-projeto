// arquivo: src/apl2/DLinkedList.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

package apl2;

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {
	// TODO: Implementar a classe conforme o enunciado da atividade Apl2.
	private Node head;
	private Node tail;
	private int count;

// OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
	public DLinkedList() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		head = null;
		tail = null;
		count = 0;
	}


// OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no início da lista.
	public void insert(String id, String nome, Float nota) {
		Node newHead = new Node();
		newHead.setId(id);
		newHead.setNome(nome);
		newHead.setNota(nota);

		//se a lista não estiver vazia, atualiza coloca o antigo head na posicao seguinte
		if (getHead() != null || !isEmpty()){
			//coloca o novo head como o anterior do antigo
			getHead().setPrevious(newHead);

			//coloca o antigo head como o proximo do novo
			newHead.setNext(getHead());
		}
		// se estiver vazia, coloca o head como tail
		else {
			tail = newHead;
		}

		head = newHead;
		count++;
	}


// OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no final da lista.
	public void append(String id, String nome, Float nota) {
		Node newNode = new Node();
		newNode.setId(id);
		newNode.setNota(nota);
		newNode.setNome(nome);

		if (isEmpty()){
			head = newNode;
		}

		else {
			newNode.setPrevious(tail);
			tail.setNext(newNode);
		}

		tail = newNode;
		count++;
	}


// OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeHead() {
		if (isEmpty()) return null;
		if (getHead() == null) return null;

		Node theHead = getHead();

		count--;

		if (theHead.getNext() == null) {
			head = null;
			tail = null;

			return theHead;
		}

		Node newHead = head.getNext();

		newHead.setPrevious(null);
		head = newHead;

		return theHead;
	}


// OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeTail() {
		//se estiver vazio retorna null
		if (isEmpty()){
			return null;
		}

		//armazena o tail em um Node
		Node nodeToRemove = tail;

		//armazena o anterior do tail em um node
		Node tailPrevious = tail.getPrevious();

		//se existir, coloca como nulo o proximo endereco
		if (tailPrevious != null){
			tailPrevious.setNext(null);
		}

		// atualiza o tail
		tail = tailPrevious;

		if (count <= 2) {
			head = tailPrevious;
		}
		count--;

		return nodeToRemove;
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node removeNode(String id) {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getHead() {
		if (isEmpty()){
			return null;
		}

		return head;
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getTail() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node getNode(String id) {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		return count;
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
	public boolean isEmpty() {
		return count == 0;
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
	public void clear() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
//					exemplo do método toString() da classe LinkedListOriginal).
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(count);
		sb.append(")\n");
		Node node = head;
		while (node != null){
			sb.append(node.toString());
			sb.append("\n");
			node = node.getNext();
		}

		return sb.toString();
	}

}