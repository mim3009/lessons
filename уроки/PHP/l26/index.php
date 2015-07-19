<?php
	$message = "Текст сообщения";
	$to = "mim.roma@mail.ru";
	$from = "roma.mim@mail.ru";
	$subject = "Тема сообщения";
	$subject = "=?utf-8?B?" . base64_encode($subject) . "?=";
	$headers = "From: $from\r\nReply-to: $from\r\nContent-type: text/plain; charset=utf-8\r\n";
	mail($to, $subject, $message, $headers);

	$message = "Сообщение с <b>HTML</b> <i>Кодом</i>";
	$headers = "From: $from\r\nReply-to: $from\r\nContent-type: text/html; charset=utf-8\r\n";
?>