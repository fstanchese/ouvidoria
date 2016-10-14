$(function(){
	if($('.galeria').length||$('.fancybox').length)
	{
		$(".galeria").fancybox(
		{
			helpers:
			{
				thumbs:
				{
					width:600,height:500
				}
			}
		}
		);
		$('.fancybox').fancybox(
		{
			width:700,height:500,type:"iframe",scrolling:"no"
		}
		).click(function(e)
		{
			e.preventDefault()
		}
		)
	}

});
function validar()
{
	"use strict";
	var form = $("#validar-contato");
	if($("input[name=nome]",form).val()==="")
	{
		alert('Preencha o campo com seu nome');
		$("input[name=nome]",form).focus();
		return false
	}
	if($("input[name=email]",form).val()==="")
	{
		alert('Preencha o campo com seu email');
		$("input[name=email]",form).focus();
		return false
	}
	if($("input[name=assunto]",form).val()==="")
	{
		alert('Preencha o campo com o assunto');
		$("input[name=assunto]",form).focus();
		return false
	}
	if($("textarea[name=mensagem]",form).val()==="")
	{
		alert('Preencha o campo com a mensagem');
		$("textarea[name=mensagem]",form).focus();
		return false
	}
};
function validar()
{
	"use strict";
	var form = $("#validar-equipe");
	if($("input[name=area]",form).val()==="")
	{
		alert('Preencha o campo com a area de interesse');
		$("input[name=area]",form).focus();
		return false
	}
	if($("input[name=telefone]",form).val()==="")
	{
		alert('Preencha o campo com um telefone para contato');
		$("input[name=telefone]",form).focus();
		return false
	}
	if($("input[name=email]",form).val()==="")
	{
		alert('Preencha o campo com seu email');
		$("input[name=email]",form).focus();
		return false
	}
	if($("input[name=nome]",form).val()==="")
	{
		alert('Preencha o campo com o seu nome completo');
		$("input[name=nome]",form).focus();
		return false
	}
	
};
