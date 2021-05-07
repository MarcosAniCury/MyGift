function renderProduct(product) {

    if (product.id != 0)
    {
        let etari = product.etaria == 0 ? "Livre" : `+${product.etaria}`
        $('#item').html(`
            <div class = "col-6">
                <li class = "media text-center">
                    <img src="./Imagem/${product.imagem}"  class = "Imagem_Produto" alt = "Descrição">
                    <div class="media-body">
                        <h2 class = "Produto mb-3">${product.nome}</h2>
                        <p class = "lead Descrição ml-mt-5">Hobbies: ${product.hobbies}<br>Faixa Etária: ${etari}.<br>Preço: ${product.preco}.</p>
                        <h4 class = "MTexto ml-3">&raquo;</h4>
                    </div>
                </li>
            </div>`
        )
    }
    else
    {
        $('#item').html(`
            <div class = "col-6">
                <li class = "media text-center">
                    <div class="media-body">
                        <h2 class = "Produto mb-3"><span class="text-danger mt-2">Produto não encontrado com os requisitos requeridos</span></h2>
                    </div>
                </li>
            </div>`
        )
    }
}


function getProduct(id_product) {
    $.get(`http://localhost:5573/presenteado/${id_product}`, res => {
        let response = JSON.parse(res)
        renderProduct(response)
    })
}

function verifyUrl() {
    const queryString = window.location.search;
    if (queryString) {
        const urlParams = new URLSearchParams(queryString);
        const product = urlParams.get('id')
        getProduct(product)
    }
}

verifyUrl()
