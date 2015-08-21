#!/usr/bin/php
<?php

  $conn = 0;
  $sep = "/";
  $root = $argv[1];
  $server = $argv[2];

  // process directory
  //
  /*function process_dir($dir) {
    global $sep;

    $files  = scandir($dir);
    foreach ($files as $key => $value) {
      //printf("%s -> %s\n", $key, $value);
      if ($value == ".") continue;
      if ($value == "..") continue;

      $path = $dir . $sep . $value;
      if (is_dir($path)) {
	printf("dir: %s\n", $path);
	process_dir($path);
      } else if (is_file($path)) {
	process_file($path);
      } else {
	printf("unknown: %s\n", $path);
      }
    }
  }

  // process file
  //
  function process_file($file) {
    global $sep, $root, $server, $conn;

    $id = substr($file, strrpos($file, $sep) + 1);
    $ext = substr($file, strrpos($file, ".") + 1);

    $id = substr($id, 0, strlen($id) - strlen($ext) - 1);

    $path = substr($file, strlen($root) + 1);
    $fullpath = $server . $sep . $path;

//    $sql = "INSERT INTO refs (id, path) values (\"" . $id . "\", \"" . $fullpath . "\")";
    $sql = "INSERT INTO refs (id, path) values (\"" . $id . "\", \"" . $path . "\")";

    if ($conn->query($sql) === TRUE) {
      printf("New record %s created successfully\n", $id);
      printf("copy(%s, %s);\n", $file, $fullpath);
      mkdir(dirname($fullpath), 0777, true);
      copy($file, $fullpath);
    } else {
      printf("Error: %s when inserting %s\n", $conn->error, $sql);
    }
  }*/

  // main
  //
  printf("root = %s\n", $root);

  // open connection
  $conn = new mysqli("localhost", "admin_assoc", "assoc2015", "association");
  if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
  } 

  process_dir($root);

  // close connection
  $conn->close();

?>
