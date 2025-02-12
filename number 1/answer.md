1. Bagaimana memori untuk list dialokasikan dan dikelola dalam metode createList?

Dalam konteks implementasi SingleLinkedList, memori untuk setiap node dialokasikan secara dinamis menggunakan operator new. Ketika kita memanggil new Node(data), Java akan mengalokasikan memori untuk objek Node baru di heap. Referensi ke node ini disimpan dalam variabel head atau dalam variabel lain yang digunakan untuk traversing linked list.

2. Apa yang akan terjadi pada memori yang dialokasikan untuk list setelah metode createList selesai dieksekusi?

Setelah metode createList selesai dieksekusi, jika tidak ada referensi lain yang menunjuk ke node-node dalam linked list, maka node-node tersebut akan menjadi tidak terjangkau. Java menggunakan Garbage Collection (GC) untuk secara otomatis mengelola memori. Ketika GC berjalan, ia akan mendeteksi bahwa node-node tersebut tidak lagi memiliki referensi yang valid dan akan membebaskan memori yang dialokasikan untuk node-node tersebut.

3. Apakah ada potensi kebocoran memori dalam kode di atas? Jelaskan jawaban Anda.

Dalam implementasi SingleLinkedList di atas, tidak ada potensi kebocoran memori yang jelas, karena semua node yang tidak lagi memiliki referensi akan dibebaskan oleh Garbage Collector. Namun, jika kita menyimpan referensi ke node-node yang telah dihapus (misalnya, jika kita menyimpan referensi ke node yang dihapus dalam variabel lain), maka memori untuk node-node tersebut tidak akan dibebaskan, yang dapat menyebabkan kebocoran memori. Selain itu, jika kita tidak menghapus semua referensi ke linked list sebelum mengakhiri program, maka memori yang dialokasikan untuk linked list tidak akan dibebaskan sampai program selesai, tetapi ini bukan kebocoran memori dalam konteks penggunaan normal.
