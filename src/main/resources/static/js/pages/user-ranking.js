// Important! This scripts assumes that a
//      const data
// containing a list of user scores is made available through Thymleaf

Highcharts.chart('scatter-plot', {
    title: {text: null}, yAxis: [{title: {text: 'Punteggio'}}], series: [{
        name: 'Data', type: 'scatter', data: data, color: 'var(--blue-3)', showInLegend: false
    }]
});

Highcharts.chart('bell-curve', {
    title: {text: null}, yAxis: [{title: {text: 'Densità di probabilità'}}], series: [{
        name: 'Distribuzione normale stimata',
        type: 'bellcurve',
        baseSeries: 'data',
        zIndex: -1,
        color: 'var(--red-3)',
        showInLegend: false
    }, {
        name: 'Data', type: 'scatter', data: data, visible: false, showInLegend: false, id: 'data'
    }]
});

Highcharts.chart('histogram', {
    title: {text: null}, yAxis: [{title: {text: 'Punteggio'}}], series: [{
        name: 'Istogramma punteggi',
        type: 'histogram',
        baseSeries: 'data',
        zIndex: -1,
        color: 'var(--green-3)',
        showInLegend: false
    }, {
        name: 'Data', type: 'scatter', data: data, visible: false, showInLegend: false, id: 'data'
    }]
});