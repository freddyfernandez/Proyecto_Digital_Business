   /* 
$(document).ready(function() {
   

    var table = $('#mydatatable').DataTable({
        "dom": '<"float-left"l><"float-right"f>t<"float-right"p>',
        "responsive": false,
        "language": {
            "url": "https://cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
        },
        "order": [[ 0, "asc" ]],
        "initComplete": function () {
            this.api().columns().every( function () {
                var that = this;

                $( 'input', this.footer() ).on( 'keyup change', function () {
                    if ( that.search() !== this.value ) {
                        that
                            .search( this.value )
                            .draw();
                        }
                });
            })
        }
    });
});

*/

$(document).ready(function() {
    $('#mydatatable').DataTable();
});





