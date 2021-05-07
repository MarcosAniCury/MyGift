let id = null

const queryString = window.location.search;
if (queryString) {
    const urlParams = new URLSearchParams(queryString);
    id = urlParams.get('id')
}

function showhobbies(hobbies) {
    hobbies.forEach(hobbie => {
        console.log(hobbie)
        let hobbie_treated = hobbie.replace(/ |\//g, "_")
        console.log(hobbie_treated)
        $(`#${hobbie_treated}`).attr('checked', 'checked');
    })
}

$.get(`http://localhost:5573/getproduto/${id}`, res => {
    let product = JSON.parse(res)
    $('#id').val(product.id)
    $('#nome').val(product.nome)
    showhobbies(product.hobbie)
    $('#etaria').val(product.etaria)
    $('#preco').val(product.preco)
    $('#imagem').val(product.imagem)
})

$('form').submit(e =>{
    e.preventDefault()

    let data = $('form').serialize()

    $.post('http://localhost:5573/alterarproduto', data, res => {
        let resp = JSON.parse(res)
        window.location.href = `./Produtos.html`
    })
})