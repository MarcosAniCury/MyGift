$('form').submit(e => {
    e.preventDefault()
    
    let data = $('form').serialize()

    $.post('http://localhost:5573/inserirproduto', data, res => {
        let response = JSON.parse(res)
        window.location.href = `./Produtos.html`
    })
})