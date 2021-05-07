
function verifyPass() {
    let mybool = true
    if ($('#inputcorreta').val() != $('#inputsenha').val()) {
        $('.result').html('As senhas devem ser iguais')
        $('#btn').addClass('disabled')
        $('#btn').attr('disabled', "disabled")
        mybool = false
    } else {
        $('.result').html('')
        $('#btn').removeClass('disabled')
        $('#btn').removeAttr('disabled')
    }
    return mybool
}
$('form').submit(e => {
    e.preventDefault()
    
    if (!verifyPass()) {
        return
    }

    let data = $('form').serialize()

    $.post('http://localhost:5573/esquecisenha', data, res => {
        let resp = JSON.parse(res)
        if(resp.status)
            window.location.href = './Index.html'
        else
            $('.result').html(`<span class="text-danger mt-2">Informações inválidas</span>`)
    })
})


$('#inputcorreta').keyup(() => verifyPass())
$('#inputsenha').keyup(() => verifyPass())

