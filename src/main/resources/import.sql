INSERT INTO tb_user (name, email, password, role) VALUES ('Bob', 'bob@gmail.com', '123456', 0);
INSERT INTO tb_user (name, email, password, role) VALUES ('Ana', 'ana@gmail.com', '123456', 1);

INSERT INTO tb_genre (name) VALUES ('Comédia')
INSERT INTO tb_genre (name) VALUES ('Ação')

INSERT INTO tb_movie (title, sub_Title, release_Year, img_Uri, synopsis, genre_Id) VALUES ('Star Wars I', 'Star Wars Theme Song John Williams', 1975, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEUUgxD2OTx_yK4uyE4moV78L2JaVKDRjw-ulBTpNTMjg6C1HMjokjkx7gpBYyWQq33Z8&usqp=CAU', 'Obi-Wan e seu mentor embarcam em uma perigosa aventura na tentativa de salvar o planeta das garras de Darth Sidious. Durante a viagem, eles conhecem um habilidoso menino e decidem treiná-lo para se tornar um Jedi. Mas o tempo irá revelar que as coisas nem sempre são o que aparentam ser.', 2);
INSERT INTO tb_movie (title, sub_Title, release_Year, img_Uri, synopsis, genre_Id) VALUES ('Star Wars II', 'Star Wars Ataque dos Clones', 2002, 'data:image/jpeg;base64,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', 'Dez anos após o primeiro encontro, Anakin Skywalker vive um romance proibido com Padmé, enquanto Obi-Wan investiga uma tentativa de assassinato do senador e descobre um exército secreto de clones criado para tentar destruir os Jedi.', 2);
INSERT INTO tb_movie (title, sub_Title, release_Year, img_Uri, synopsis, genre_Id) VALUES ('Debi & Loide', 'Dois idiotas em apuros', 1994, 'data:image/jpeg;base64,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', 'Dois amigos debilóides vão para Aspen, no estado do Colorado para tentar devolver uma maleta esquecida pela passageira da limusine que um deles estava dirigindo para o aeroporto. Sem saber que na mala havia uma quantia enorme de dinheiro, que serviria para pagar o resgate de um sequestro, os dois acabam sendo perseguidos pela polícia e por assassinos profissionais.', 1);

INSERT INTO tb_review (text, movie_Id, user_Id) VALUES ('Filme muito engraçado, assistiria diversas outras vezes!!', 3, 2);
INSERT INTO tb_review (text, movie_Id, user_Id) VALUES ('Acho que é realmente necessário ver o primeiro filme para poder entender este...', 2, 2);