function render (products) {
    $("#Main").html('')

    for (let i = 1; i <= products.length; i++) {
        $("#Main").append(`
            <div class = "col media m-3" width="50%">
                <img src = "./Imagem/${products[i-1]["imagem"]}" class = "mr-3" width="320" alt = "Descrição">
                <div class = "media-body">
                    <h2 class = "Produto mb-3">
                        ${products[i-1].nome}
                    </h2>
                    <p class = "lead Descrição ml-mt-5">
                        Hobbies:  ${products[i-1].hobbies}
                    </p>
                    <p class = "lead Descrição ml-mt-5">
                        Faixa Etária: ${products[i-1].etaria}
                    </p>
                    <p class = "lead Descrição ml-mt-5">
                        Preço: ${products[i-1].preco}
                    </p>
                    <p>
                        id: ${products[i-1].id}
                    </p>
                    <div>
                        <h3 class = "Descrição" name = "id">Ações</h3>
                        <button class="btn btn-warning" onclick="UpdateProduct(${products[i-1].id})">Editar</button>

                        <button class="btn btn-danger" onclick="DeleteProduct(${products[i-1].id})">Deletar</button>
                    </div>
                </div>
            </div>
        `)

        if (i % 2 == 0) {
            $("#Main").append(`<div class="w-100"></div>`)
        }
    }
}

function GetAllProduct() {
    $.get(`/listarprodutos`, res => {
        let products = JSON.parse(res)
        render(products)
    })
}

function UpdateProduct(id) {
    window.location.href = `./Alterar.html?id=${id}`
}

function DeleteProduct(id) {
    if (confirm('Deseja realmente deletar este produto?')) {
        $.post('/deletarproduto', {id: id}, res => {
            let data = JSON.parse(res)
            if (data.status) {
                alert('Produto deletado com sucesso!')
            } else {
                alert('Produto Não deletado com sucesso!')
            }
            GetAllProduct()
        })
    }
}

GetAllProduct()