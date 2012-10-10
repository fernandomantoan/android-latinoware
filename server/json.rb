require 'sinatra'

get '/' do
	content_type :json

	'
		{
			"speechs":[
				{
					"title":"Linux Kernel Hacking - What I Learned While Hanging Out With Smart People",
					"dateTime":"2012-10-17 10:00:00",
					"speaker":[
						{
							"name":"Rusty Russels",
							"bio":null
						}
					],
					"space":"Espa\u00e7o Brasil",
					"description":null,
					"type":"KEYNOTE"
				},
				{
					"title":"Privacidade e Seguran\u00e7a de Crian\u00e7as nas Redes Sociais",
					"dateTime":"2012-10-17 11:00:00",
					"speaker":[
						{
							"name":"Gracielle Torres",
							"bio":null
						}
					],
					"space":"Espa\u00e7o Brasil",
					"description":null,
					"type":null
				},
				{
					"title":"A breve hist\u00f3ria da Computa\u00e7\u00e3o nas Nuvens. ambiente virtual de IaaS a partir da an\u00e1lise do Openstack e de outras solu\u00e7\u00f5es existentes.",
					"dateTime":"2012-10-18 10:00:00",
					"speaker":[
						{
							"name":"Marcelo Dieder",
							"bio":null
						}
					],
					"space":"Espa\u00e7o Brasil",
					"description":null,
					"type":null
				},
				{
					"title":"O emprego de Software Livre no desenvolvimento de simulador gr\u00e1fico realista para o treinamento para Operadores de Usinas e Subesta\u00e7\u00f5es",
					"dateTime":"2012-10-18 10:00:00",
					"speaker":[
						{
							"name":"\u00c2ngelo Andelnyr Sampaio Alves",
							"bio":null
						}
					],
					"space":"Espa\u00e7o Paraguai",
					"description":null,
					"type":null
				},
				{
					"title":"Certifica\u00e7\u00e3o em Linux - Palestra com convidado especial Jon Maddog Hall",
					"dateTime":"2012-10-19 16:00:00",
					"speaker":[
						{
							"name":"Jon \"Maddog\" Hall",
							"bio":null
						},
						{
							"name":"Alessandro Silva",
							"bio":null
						}
					],
					"space":"Espa\u00e7o Brasil",
					"description":null,
					"type":null
				},
				{
					"title":"The State of OSGEO - Open Source Geospatial Foundation",
					"dateTime":"2012-10-19 17:00:00",
					"speaker":[
						{
							"name":"Jody Garnett",
							"bio":null
						}
					],
					"space":"Espa\u00e7o Brasil",
					"description":null,
					"type":"KEYNOTE"
				}
			],
			"courses":[
				{
					"title":"Inkscape Produ\u00e7\u00e3o Gr\u00e1fico Vetorial",
					"dateTimes":["2012-10-17 16:00:00","2012-10-17 17:00:00"],
					"teachers":[
						{
							"name":"Luciano Louren\u00e7o da Silva",
							"bio":null
						}
					],
					"lab":"LAB 1",
					"description":null
				},
				{
					"title":"Bacula",
					"dateTimes":["2012-10-18 10:00:00","2012-10-18 11:00:00","2012-10-18 12:00:00","2012-10-18 13:00:00"],
					"teachers":[
						{
							"name":"Heitor Faria",
							"bio":null
						}
					],
					"lab":"LAB 1",
					"description":null
				},
				{
					"title":"Construindo Gateways seguros com IPTables e Hardening de servidores",
					"dateTimes":["2012-10-19 14:00:00","2012-10-19 15:00:00","2012-10-19 16:00:00","2012-10-19 17:00:00"],
					"teachers":[
						{
							"name":"Marta Vuelma",
							"bio":null
						}
					],
					"lab":"LAB 1",
					"description":null
				}
			]
		}
	'
end