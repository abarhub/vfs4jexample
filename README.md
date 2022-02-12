# vfs4jexample

Exemple d'utilisation de la librairie [vfs4j](https://github.com/abarhub/vfs4j)

Pour lancer l'exemple, il faut builder le projet `mvn clean install`, puis il faut lancer la commande `run.bat`.
Le projet a été fait sous windows, mais il peut être adapter facilement sous linux en s'inspirant du run.bat et en modifiant le fichier conf/vfs4j.properties

## Exemple 1

C'est le script `run.bat` qu'il faut executer.
Cela crée deux fichiers.
Voici le log :
```log
18:47:12.362 [main] INFO  org.vfs4j.example.simple.Main - main
18:47:12.366 [main] INFO  io.github.abarhub.vfs.core.api.VFS4JDefaultFileManager - Start initialization
18:47:12.368 [main] INFO  io.github.abarhub.vfs.core.api.VFS4JDefaultFileManager - VFS4J config file is '.\conf\vfs.properties'
18:47:12.372 [main] INFO  io.github.abarhub.vfs.core.config.VFS4JConfig - config map: {dir2=VFS4JPathParameter[path=D:\projet\vfs4jexample\simple\workspace\dir2, readonly=false, mode=STANDARD], dir1=VFS4JPathParameter[path=D:\projet\vfs4jexample\simple\workspace\dir1, readonly=false, mode=STANDARD]}
18:47:12.374 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - create VFS4JAuditPlugins
18:47:12.374 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - init VFS4JAuditPlugins: plugins1
18:47:12.376 [main] INFO  io.github.abarhub.vfs.core.config.VFS4JConfig - config plugins: {plugins1=io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins@7e5afaa6, plugins2=io.github.abarhub.vfs.core.plugin.unclosed.VFS4JUnclosedPlugins@63a12c68}
18:47:12.382 [main] INFO  io.github.abarhub.vfs.core.api.VFS4JDefaultFileManager - End initialization
18:47:12.384 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - deleteIfExists for file dir1:fichier1.txt
18:47:12.384 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - deleteIfExists for file dir1:fichier2.txt
18:47:12.385 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - deleteIfExists for file dir2:fichier1.txt
18:47:12.385 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - deleteIfExists for file dir2:fichier2.txt
18:47:12.388 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - createFile for file dir1:fichier1.txt
18:47:12.388 [main] INFO  org.vfs4j.example.simple.Main - create dir1:fichier1.txt
18:47:12.389 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - write for file dir1:fichier2.txt
18:47:12.389 [main] INFO  org.vfs4j.example.simple.Main - create dir1:fichier2.txt
18:47:12.389 [main] INFO  org.vfs4j.example.simple.Main - file dir1:fichier1.txt exists
18:47:12.389 [main] INFO  org.vfs4j.example.simple.Main - file dir1:fichier2.txt exists
18:47:12.389 [main] INFO  org.vfs4j.example.simple.Main - copy from dir1:fichier1.txt to dir2:fichier1.txt
18:47:12.391 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - copy from file dir1:fichier1.txt to file dir2:fichier1.txt
18:47:12.391 [main] INFO  org.vfs4j.example.simple.Main - copy from dir1:fichier2.txt to dir2:fichier2.txt
18:47:12.392 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - copy from file dir1:fichier2.txt to file dir2:fichier2.txt
18:47:12.392 [main] INFO  org.vfs4j.example.simple.Main - file dir2:fichier1.txt exists
18:47:12.392 [main] INFO  org.vfs4j.example.simple.Main - file dir2:fichier2.txt exists
18:47:12.392 [main] INFO  org.vfs4j.example.simple.Main - files dir1:fichier2.txt and dir2:fichier2.txt are equals
18:47:12.392 [main] INFO  org.vfs4j.example.simple.Main - Fin du programme
```


## Exemple 2

C'est le script `run_test2.bat` qu'il faut executer.
Cela ouvre un fichier, sans le fermé, puis ça appel System.gc(), et dans les log, il y a un message informatif.

```log
18:48:13.698 [main] INFO  org.vfs4j.example.simple.Main - main
18:48:13.701 [main] INFO  io.github.abarhub.vfs.core.api.VFS4JDefaultFileManager - Start initialization
18:48:13.704 [main] INFO  io.github.abarhub.vfs.core.api.VFS4JDefaultFileManager - VFS4J config file is '.\conf\vfs.properties'
18:48:13.709 [main] INFO  io.github.abarhub.vfs.core.config.VFS4JConfig - config map: {dir2=VFS4JPathParameter[path=D:\projet\vfs4jexample\simple\workspace\dir2, readonly=false, mode=STANDARD], dir1=VFS4JPathParameter[path=D:\projet\vfs4jexample\simple\workspace\dir1, readonly=false, mode=STANDARD]}
18:48:13.710 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - create VFS4JAuditPlugins
18:48:13.711 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - init VFS4JAuditPlugins: plugins1
18:48:13.714 [main] INFO  io.github.abarhub.vfs.core.config.VFS4JConfig - config plugins: {plugins1=io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins@7e5afaa6, plugins2=io.github.abarhub.vfs.core.plugin.unclosed.VFS4JUnclosedPlugins@63a12c68}
18:48:13.721 [main] INFO  io.github.abarhub.vfs.core.api.VFS4JDefaultFileManager - End initialization
18:48:13.723 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - deleteIfExists for file dir1:fichier1.txt
18:48:13.727 [main] INFO  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPlugins - write for file dir1:fichier1.txt
18:48:13.727 [main] INFO  org.vfs4j.example.simple.Main - create dir1:fichier1.txt
18:48:13.728 [main] WARN  io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPluginsFactory - open for 1 (path=dir1:fichier1.txt)
18:48:13.736 [VFS4JUnclosedPlugins.plugins2] ERROR io.github.abarhub.vfs.core.plugin.audit.VFS4JAuditPluginsFactory - finalizer for 1 (path=dir1:fichier1.txt, duration=PT0.0070009S)
18:48:18.739 [main] INFO  org.vfs4j.example.simple.Main - end
18:48:18.739 [main] INFO  org.vfs4j.example.simple.Main - Fin du programme
```
