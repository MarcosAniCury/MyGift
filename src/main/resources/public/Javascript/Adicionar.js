$('form').submit(e => {
    e.preventDefault()
    
    let data = $('form').serialize()

    $.post('/inserirproduto', data, res => {
        let response = JSON.parse(res)
        window.location.href = `./Produtos.html`
    })
})