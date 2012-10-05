require 'sinatra'

get '/' do
	content_type :json

	'
		{
			"speechs":[
				{
					"title":"Kernel Security",
					"date":"2012-10-17",
					"time":"10:00:00",
					"speaker":"Rusty Russels",
					"space":"Espa\u00e7o Brasil"
				},
				{
					"title":"Privacidade e Seguran\u00e7a de Crian\u00e7as nas Redes Sociais",
					"date":"2012-10-17",
					"time":"11:00:00",
					"speaker":"Gracielle Torres",
					"space":"Espa\u00e7o Brasil"
				},
				{
					"title":"A breve hist\u00f3ria da Computa\u00e7\u00e3o nas Nuvens. ambiente virtual de IaaS a partir da an\u00e1lise do Openstack e de outras solu\u00e7\u00f5es existentes.",
					"date":"2012-10-18",
					"time":"10:00:00",
					"speaker":"Marcelo Dieder",
					"space":"Espa\u00e7o Brasil"
				},
				{
					"title":"O emprego de Software Livre no desenvolvimento de simulador gr\u00e1fico realista para o treinamento para Operadores de Usinas e Subesta\u00e7\u00f5es",
					"date":"2012-10-18",
					"time":"10:00:00",
					"speaker":"\u00c2ngelo Andelnyr Sampaio Alves",
					"space":"Espa\u00e7o Paraguai"
				},
				{
					"title":"Certifica\u00e7\u00e3o em Linux - Palestra com convidado especial Jon Maddog Hall",
					"date":"2012-10-19",
					"time":"16:00:00",
					"speaker":"Jon \"Maddog\" Hall","space":"Espa\u00e7o Brasil"
				},
				{
					"title":"The State of OSGEO - Open Source Geospatial Foundation",
					"date":"2012-10-19",
					"time":"17:00:00",
					"speaker":"Jody Garnett",
					"space":"Espa\u00e7o Brasil"
				}
			]
		}
	'
end