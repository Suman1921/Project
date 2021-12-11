
$(function() {

	var $table = $('#productTable');

	if ($table.length) {

		var jsonUrl = '';
		if (window.category_Id == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/'
				+ window.category_Id + '/products';
		}


		$table.DataTable({
			lengthMenu: [[3, 5, 10, -1],
			['3 Items', '5 Items', '10 Items', 'ALL Items']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'code',
					bSortable: false,
					mRender: function(data, type, row) {

						return '<img src="' + window.contextRoot
							+ '/rs/images/' + data
							+ '.jpeg" class="dataTableImg"/>';

					}
				},
				{
					data: 'name'
				}, {
					data: 'brand'
				}, {
					data: 'unitPrice',
					mRender: function(data, type, row) {
						return '&#8377; ' + data
					}

				}, {
					data: 'quantity',
					mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
				},
				{
				data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/product/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

									if (userRole  !== 'ADMIN' ) 
									{
										if (row.quantity < 1) 
										{
											str += '<a href="javascript:void(0)" class="btn btn-warning disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										} 
										else 
										{
											str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										}
									} 
									else 
									{
										str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span></a> ';
									}

									return str;

								}
			}
			]
		});
	}
	
	
	
	// Admin DataTable
	
var $table = $('#adminProductsTable');

	if ($table.length) {

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$table
				.DataTable({
					lengthMenu : [ [ 5, 10, 20, -1 ],
							[ '5 Items', '10 Items', '20 Items', 'ALL Items' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="'
											+ window.contextRoot
											+ '/rs/images/'
											+ data
											+ '.jpeg" class="adminDataTableImg"/>';

								}
							},

							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if (data) {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '" checked="checked">  <div class="slider round"> </div></label>';

									} else {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '">  <div class="slider round"> </div></label>';
									}

									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span></a> &#160;';

									return str;
								}
							},
					],

					initComplete : function() {
						var api = this.api();

						api.$('.switch input[type = "checkbox"]')
							.on('change', function() {
											var checkbox = $(this);
											var checked = checkbox.prop('checked');
											var msg = (checked) ? '<h3 class="text-warning">You want to activate the product?</h3>'
													: '<h3 class="text-warning">You want to deactivate the product?</h3>';
											var value = checkbox.prop('value');
											console.log(value);
											bootbox.confirm({
														size : 'medium',
														title : '<h2 class="text-primary font-weight-bolder text-center">Product Activation/Deactivation</h2>',
														message : msg,
														callback : function(confirmed) {
															if (confirmed) {
																var activeurl = window.contextRoot
																		+ '/manage/product/'
																		+ checkbox.prop('value')
																		+ '/activation';
																$.post(activeurl, function(data) {
																					bootbox.alert({
																								size : 'medium',
																								title : '<h2 class="text-primary text-center font-weight-bolder">Information</h2>',
																								message : data,
																							});
																				});

															} else {
																checkbox.prop('checked', !checked);
															}
														},
													});
										});
					}
					
					
										
				});
	}
	
	
	//HANDLE PAGE REFRESH
	
	$('button[name="refreshCart"]').click(function()
			{
				var cartLineId = $(this).attr('value');
				
				var countField = $('#count_' + cartLineId);
				
				var originalCount = countField.attr('value');
				

				var updatedCount = countField.val();
				// do the checking only the count has changed
				if(updatedCount != originalCount) 
				{	
					// check if the quantity is within the specified range
					if(updatedCount < 1 || updatedCount > 5) 
					{
						// set the field back to the original field
						countField.val(originalCount);
						bootbox.alert({
								size: 'medium',
								title: '<h2 class="text-primary text-center font-weight-bolder">Error</h2>',
								message: '<h3 class="text-warning">Product Count should be minimum 1 and maximum 5!</h3>'
						});
					}
					else 
					{
						// use the window.location.href property to send the request to the server
						var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + updatedCount;
						window.location.href = updateUrl;
					}
				}
	});	
	
	
});